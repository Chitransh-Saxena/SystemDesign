import java.util.UUID;

/*
    This is the main Message Queue or MQ class
    This will be responsible for
        -> Creating a topic
        -> Add subscribers to a particular topic
        -> Publishing a message to a certain topic
            -> What do we need for this to happen on a very basic level?
                -> A topic to which a message has to be published
                -> A message which would be published to a topic

        -> We will need some other entities/objects for this, but I am not able to think them right away
            -> So, let's start by creating with what we have
            -> We can include if something is needed on the way
*/

public class MessageQueue {
    

    // Simply creating a Topic entity
    public Topic createTopic(String topicName) {

        Topic topic = new Topic(topicName, UUID.randomUUID().toString());


        System.out.println("====Topic Created====\n" + topic.getTopicName());
        return topic;
    }

    // Subscribe to a topic
    public void subscribe(Subscriber subscriber, Topic topic) {

        topic.addSubscriber(subscriber);
        System.out.println("Subscriber " + subscriber.getName() + " is subscribed to the topic " + topic.getTopicName());
    }

    // Publishing the message - Add message to the topic, and publish this message to all the subscribers
    public void publish(Message message, Topic topic) {

        /*
            -> Now, in this step, I notice there are few things missing that I should have done
                -> Till now I only have only createTopic(), subcribe(), and publish() is in writing
                -> What am I missing?
                    -> How is the topic going to be published among all the subscribers of a topic?
                    -> One idea is threading. Correct, but how?
                    -> If I start the thread for MessageQueue object, it would block the caller object for a long time (potentially)
                        -> So, I need a seprate handler which would do this job for me, so that I can call that object from here  and not block the caller object
        */

        
    }

}
