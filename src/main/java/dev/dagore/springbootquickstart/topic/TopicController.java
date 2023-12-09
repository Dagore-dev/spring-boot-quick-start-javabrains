package dev.dagore.springbootquickstart.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topics")
public class TopicController {
  @Autowired
  private TopicService topicService;

  @GetMapping
  public List<Topic> getAllTopics() {
    return topicService.getAllTopics();
  }

  @GetMapping("/{id}")
  public Topic geTopicById(@PathVariable String id) {
    return topicService.getTopicById(id);
  }

  @PostMapping
  public void addTopic(@RequestBody Topic topic) {
    topicService.addTopic(topic);
  }

  @PutMapping("/{id}")
  public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
    topicService.updateTopic(id, topic);
  }

  @DeleteMapping("/{id}")
  public void deleteTopic(@PathVariable String id) {
    topicService.deleteTopic(id);
  }
}
