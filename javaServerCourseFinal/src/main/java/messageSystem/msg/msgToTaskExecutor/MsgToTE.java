package messageSystem.msg.msgToTaskExecutor;

import messageSystem.msg.Abonent;
import messageSystem.msg.Address;
import messageSystem.msg.Msg;
import services.taskExecutor.TaskExecutor;

/**
 * Created by clr on 21.12.2016.
 */
public abstract class MsgToTE extends Msg {
    public MsgToTE(Address from, Address to) {
        super(from, to);
    }

    public void exec(Abonent abonent) {
        if(abonent instanceof TaskExecutor) {
            exec((TaskExecutor) abonent);
        }
    }

    public abstract void exec(TaskExecutor taskExecutor);
}
