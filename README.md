# ActiveMQ Messaging Models: Queues vs Topics

In ActiveMQ, queues and topics serve distinct purposes within messaging systems, each implementing different messaging patterns. Below is a summary of their key differences:

| Feature                 | Queues                             | Topics                             |
|-------------------------|------------------------------------|------------------------------------|
| **Messaging Model**     | Point-to-point                     | Publish-subscribe                   |
| **Message Delivery**    | One consumer per message           | All subscribed consumers receive messages |
| **Message Retention**   | Messages are removed after consumption | Messages are retained for all subscribers |
| **Use Cases**           | Task processing, job queues        | Event notifications, broadcasts     |
| **Order Guarantees**    | Typically maintains order           | May not guarantee order            |

## Details

### Queues
- **Messaging Pattern**: Implement a point-to-point model where each message is sent to a specific queue, and only one consumer will receive and process that message.
- **Concurrency**: Multiple consumers can read from the same queue, but only one consumer will receive each message, allowing for load balancing.
- **Use Case**: Ideal for scenarios requiring each message to be processed exactly once, such as task processing or job scheduling.

### Topics
- **Messaging Pattern**: Implement a publish-subscribe model where messages are sent to a topic, and all subscribed consumers receive a copy of each message.
- **Subscriber Types**: Support durable and non-durable subscribers, where durable subscribers receive messages even when disconnected at the time of publication.
- **Use Case**: Best suited for broadcasting messages to multiple consumers, such as event notifications or news feeds.

## Conclusion
The choice between queues and topics depends on the specific use case. Use queues when you need to ensure that each message is processed by only one consumer, and use topics when you want to broadcast messages to multiple consumers simultaneously.
