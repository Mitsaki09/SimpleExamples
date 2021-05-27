
import StudentTeacher.{Student, Teacher}
import akka.actor.{Actor, ActorRef, ActorSystem, Props}

class StudentActor extends Actor {
  def receive = {
    case student: Student =>
      println(student)

  }
}

class TeacherActor extends Actor {
  def receive = {
    case teacher:Teacher =>

      teacher.task ! Teacher(self, teacher.explanation)

  }
}

object StudentTeacher {
  case class Student(description: String)
  case class Teacher(task: ActorRef, explanation: String)
}
object MainStudentTeacher extends App {
  val system = ActorSystem("Actor")
  val studentActor = system.actorOf(Props[StudentActor], name = "studentActor")
  val teacher = Teacher(studentActor, "пиши")
  val teacherActor = system.actorOf(Props[TeacherActor], name = "teacherActor")
  teacherActor ! teacher
}
