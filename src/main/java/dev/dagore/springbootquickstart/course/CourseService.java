package dev.dagore.springbootquickstart.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
  @Autowired
  private CourseRepository courseRepository;

  public List<Course> getAllCoursesByTopicId(String topicId) {
    List<Course> coursesList = new ArrayList<>();
    courseRepository
        .findByTopicId(topicId)
        .forEach(coursesList::add);

    return coursesList;
  }

  public Course getCourseById(String id) {
    return courseRepository.findById(id).orElseThrow();
  }

  public void addCourse(Course course) {
    courseRepository.save(course);
  }

  public void updateCourse(String id, Course course) {
    courseRepository.save(course);
  }

  public void deleteCourseById(String id) {
    courseRepository.deleteById(id);
  }
}
