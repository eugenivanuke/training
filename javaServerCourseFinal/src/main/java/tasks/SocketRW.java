package tasks;

import messageSystem.msg.Abonent;
import messageSystem.msg.Address;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by clr on 11.12.2016.
 */
public class SocketRW implements Abonent, Runnable {
    private final SocketChannel channel;
    private Address address;

    public SocketRW(SocketChannel channel) {
        this.channel = channel;
        this.address = new Address();
    }

    @Override
    public Address getAddress() {
        return this.address;
    }

    public void run() {
        ByteBuffer buffer = ByteBuffer.allocate(64);
        boolean read = false, done = false;
        String response = null;
        try {
            Selector selector = Selector.open();
            channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            while (!done) {
                selector.select();
                Iterator it = selector.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey key = (SelectionKey) it.next();
                    it.remove();
                    if (key.isReadable() && !read) {
                        if (channel.read(buffer) > 0)
                            read = true;
                        ByteBuffer byteBuffer = (ByteBuffer) buffer.flip();
                        response = byteBuffer.toString();
                    }
                    if (key.isWritable() && read) {
                        System.out.print("Echoing : " + response);
                        channel.write((ByteBuffer) buffer.rewind());
                        if (response.contains("END"))
                            done = true;
                        buffer.clear();
                        read = false;
                    }
                }
            }
        }
        catch (IOException e) {
            // будет поймано Worker.java и залогировано.
            // Необходимо выбросить исключение времени выполнения, так как мы не
            // можем
            // оставить IOException
            throw new RuntimeException(e);
        }
        finally {
            try {
                channel.close();
            }
            catch (IOException e) {
                System.out.println("Channel not closed.");
                // Выбрасываем это, чтобы рабочая нить могла залогировать.
                throw new RuntimeException(e);
            }
        }
    }
}
