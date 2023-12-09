package dev.dagore.springbootquickstart.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
  private List<Topic> topicsList = new ArrayList<>(Arrays.asList(
      new Topic("spring", "Spring Framework", "Spring Framework description"),
      new Topic("java", "Core java", "Core java description"),
      new Topic("javascript", "Javascript", "Javascript description")));

  public List<Topic> getAllTopics() {
    return topicsList;
  }

  public Topic getTopicById(String id) {
    return topicsList.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
  }

  public void addTopic(Topic topic) {
    topicsList.add(topic);
  }

  public void updateTopic(String id, Topic topic) {
    for (int i = 0; i < topicsList.size(); i++) {
      Topic t = topicsList.get(i);
      if (t.getId().equals(topic.getId())) {
        topicsList.set(i, topic);
        return;
      }
    }
  }

  public void deleteTopic(String id) {
    topicsList.removeIf(t -> t.getId().equals(id));
  }
}
