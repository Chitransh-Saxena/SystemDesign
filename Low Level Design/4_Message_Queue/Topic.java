import java.util.ArrayList;
import java.util.List;

public class Topic {

    private final String topicName;
    private final String topicID;

    // A DS to store all the subscribers to a particular topic
    private List<TopicSubscriber> subscribers;

    public Topic(String topicName, String topicID) {

        this.topicName = topicName;
        this.topicID = topicID;
        this.subscribers = new ArrayList<>();
    }

    public void addSubscriber(@NonNull TopicSubsriber subscriber) {

        subscribers.add(subscriber);
    }

    public String getTopicName() {
        return topicName;
    }
    
}
