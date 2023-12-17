package dev.dagore.springbootquickstart.course;

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

import dev.dagore.springbootquickstart.topic.Topic;

@RestController
@RequestMapping("topics/{topicId}/courses")
public class CourseController {
  @Autowired
  private CourseService courseService;

  @GetMapping
  public List<Course> getAllCoursesByTopicId(@PathVariable String topicId) {
    return courseService.getAllCoursesByTopicId(topicId);
  }

  @GetMapping("/{id}")
  public Course getCourseById(@PathVariable String id) {
    return courseService.getCourseById(id);
  }

  @PostMapping
  public void addCourse(@PathVariable String topicId, @RequestBody Course course) {
    course.setTopic(new Topic(topicId, "", ""));
    courseService.addCourse(course);
  }

  @PutMapping("/{id}")
  public void updateCourse(@PathVariable String topicId, @PathVariable String id, @RequestBody Course course) {
    course.setTopic(new Topic(topicId, "", ""));
    courseService.updateCourse(id, course);
  }

  @DeleteMapping("/{id}")
  public void deleteCourseById(@PathVariable String id) {
    courseService.deleteCourseById(id);
  }
}
