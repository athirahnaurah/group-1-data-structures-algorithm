public class TimeResult<T> {

    private T result;
    private long time; // nanoseconds

    public TimeResult(T result, long time){
        this.result = result;
        this.time = time;
    }

    public T getResult(){
        return result;
    }

    public long getTime(){
        return time;
    }
}
