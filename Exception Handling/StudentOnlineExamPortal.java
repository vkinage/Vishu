// An online exam portal must validate student submissions. Implement Exception 
// Handling:    Custom Exceptions:   • ExamTimeExpiredException (checked) — 
// thrown if submission time > allowed duration   • InvalidAnswerFormatException 
// (unchecked) — thrown if answer is null or empty   • AlreadySubmittedException 
// (checked) — thrown if student tries to submit twice    Class 'ExamPortal':   • 
// Method submitExam(Student s, long timeTaken, String[] answers) — validates 
// all conditions   • Uses try-catch-finally: finally prints "Session closed for 
// <studentName>"  Tasks:   (a) Simulate 4 submission attempts: valid, time 
// expired (95 min for 90 min exam),       invalid answer (null), already submitted   
// (b) Catch exceptions separately with user-friendly error messages   (c) 
// Demonstrate creating and throwing custom checked exception with a message   
// (d) Use multi-catch (|) syntax for AlreadySubmittedException | 
// ExamTimeExpiredException 

// Custom Checked Exception
class ExamTimeExpiredException extends Exception {

    ExamTimeExpiredException(String message) {
        super(message);
    }
}


// Custom Unchecked Exception
class InvalidAnswerFormatException extends RuntimeException {

    InvalidAnswerFormatException(String message) {
        super(message);
    }
}


// Custom Checked Exception
class AlreadySubmittedException extends Exception {

    AlreadySubmittedException(String message) {
        super(message);
    }
}


// Student Class
class Student {

    String name;
    boolean submitted = false;

    Student(String name) {
        this.name = name;
    }
}


// ExamPortal Class
class ExamPortal {

    int allowedDuration = 90;

    // Method to submit exam
    void submitExam(Student s, long timeTaken, String[] answers)
            throws ExamTimeExpiredException, AlreadySubmittedException {

        try {

            // Check already submitted
            if (s.submitted) {
                throw new AlreadySubmittedException(
                        "Exam already submitted by " + s.name);
            }

            // Check exam time
            if (timeTaken > allowedDuration) {
                throw new ExamTimeExpiredException(
                        "Exam time expired for " + s.name);
            }

            // Check answers
            for (String ans : answers) {

                if (ans == null || ans.isEmpty()) {
                    throw new InvalidAnswerFormatException(
                            "Invalid answer format found");
                }
            }

            // Successful submission
            s.submitted = true;

            System.out.println("Exam submitted successfully for " + s.name);

        }

        finally {

            System.out.println("Session closed for " + s.name);
        }
    }
}


// Main Class
public class StudentOnlineExamPortal {

    public static void main(String[] args) {

        ExamPortal portal = new ExamPortal();

        Student s1 = new Student("Raj");

        // 1. Valid Submission
        try {

            String[] answers1 = {"A", "B", "C"};

            portal.submitExam(s1, 85, answers1);

        }

        catch (AlreadySubmittedException | ExamTimeExpiredException e) {

            System.out.println(e.getMessage());
        }

        catch (InvalidAnswerFormatException e) {

            System.out.println(e.getMessage());
        }

        // 2. Time Expired
        try {

            Student s2 = new Student("Raj");

            String[] answers2 = {"A", "B", "C"};

            portal.submitExam(s2, 95, answers2);

        }

        catch (AlreadySubmittedException | ExamTimeExpiredException e) {

            System.out.println(e.getMessage());
        }

        catch (InvalidAnswerFormatException e) {

            System.out.println(e.getMessage());
        }

        // 3. Invalid Answer
        try {

            Student s3 = new Student("Raj");

            String[] answers3 = {"A", null, "C"};

            portal.submitExam(s3, 80, answers3);

        }

        catch (AlreadySubmittedException | ExamTimeExpiredException e) {

            System.out.println(e.getMessage());
        }

        catch (InvalidAnswerFormatException e) {

            System.out.println(e.getMessage());
        }

        // 4. Double Submit
        try {

            String[] answers4 = {"A", "B", "C"};

            portal.submitExam(s1, 70, answers4);

        }

        catch (AlreadySubmittedException | ExamTimeExpiredException e) {

            System.out.println(e.getMessage());
        }

        catch (InvalidAnswerFormatException e) {

            System.out.println(e.getMessage());
        }
    }
}