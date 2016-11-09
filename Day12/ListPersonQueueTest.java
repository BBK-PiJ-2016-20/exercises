public class ListPersonQueueTest extends PersonQueueTest {
    protected PersonQueue createQueue() {
        return new ListPersonQueue();
    }
}