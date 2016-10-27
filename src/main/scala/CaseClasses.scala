
abstract class Notification
case class Email(sourceEmail: String, title: String, body: String) extends Notification
case class SMS(sourceNumber: String, message: String) extends Notification
case class VoiceRecording(contactName: String, link: String ) extends Notification

object CaseClassesTest extends App {

  val emailFromJohn = Email("john.doe@mail.com","Greeting From John!!","Hello World!!")
  val title = emailFromJohn.title
  println(title)

  val editedEmail = emailFromJohn.copy(title="I am learning Scala!!", body="It's so cool")

  println(editedEmail)

  def showNotification(notification: Notification): String = {
    notification match {
      case Email(email,title,_) => "You got an email from "+email+ " with title "+title
      case SMS(number,message) => "You got an SMS from "+number+" ! Message: "+message
      case VoiceRecording(name,link) => "You received a Voice Recording from "+name+ "! Click the link to hear it: "+ link
    }
  }

  val someSms = SMS("12345","Are you there ?")
  val someVoiceRecording = VoiceRecording("Tom","voicerecording.org/id/123")

  println(showNotification(someSms))
  println(showNotification(someVoiceRecording))

  def showNotification2(notification: Notification,specialEmail: String,specialNumber: String): String = {
      notification match {
        case Email(email,_,_) if email == specialEmail => "You got email from special one!!"
        case SMS(number,_) if number == specialNumber => "You got an SMS from special someone!!"
        case other => showNotification(other)
      }
  }

  val SPECIAL_NUMBER = "55555"
  val SPECIAL_EMAIL = "jane@mail.com"
  val someSms2 = SMS("12345","Are you there??")
  val someVoiceRecording2 = VoiceRecording("Tom","voicerecording.org/id/123")
  val specialEmail2 = Email("jane@mail.com", "Drinks tonight?", "I'm free after 5!")
  val specialSms2 = SMS("55555", "I'm here! Where are you?")

  println(showNotification2(specialEmail2,SPECIAL_EMAIL,SPECIAL_NUMBER))



}
