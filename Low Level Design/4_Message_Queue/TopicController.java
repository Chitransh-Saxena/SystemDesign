/*
    We created this class out of the need of publishing a message to all the subscribers.
    We did this because caller object will the MQ and if MQ would have started it's own threads, MQ could have been blocked


    Requirements to be fulfilled from this class
        -> Save a topic
        -> publish

*/

public class TopicController extends Thread{
    
    private final Topic topic;
    // private final HashMap<String, SubscribeW


    // What else does a topic controller need to be constructed? I guess only Topic
    public TopicController(Topic topic) {
        
        this.topic = topic;
    }
}
