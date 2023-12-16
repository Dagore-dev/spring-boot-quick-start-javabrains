package dev.dagore.springbootquickstart.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
  @Autowired
  private TopicRepository topicRepository;

  public List<Topic> getAllTopics() {
    List<Topic> topicsList = new ArrayList<>();
    topicRepository
        .findAll()
        .forEach(topicsList::add);

    return topicsList;
  }

  public Topic getTopicById(String id) {
    return topicRepository.findById(id).orElseThrow();
  }

  public void addTopic(Topic topic) {
    topicRepository.save(topic);
  }

  public void updateTopic(String id, Topic topic) {
    topicRepository.save(topic);
  }

  public void deleteTopic(String id) {
    topicRepository.deleteById(id);
  }
}
