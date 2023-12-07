import java.sql.Date;

public class Reviews {
    
     private int review_id;

     private int program_id;
    
     private int athlete_id;

     private int coach_id;

     private int rating;

     private String review_txt;

     private Date date;

    public Reviews(int review_id, int program_id, int athlete_id, int coach_id, int rating, String review_txt,
            Date date) {
        this.review_id = review_id;
        this.program_id = program_id;
        this.athlete_id = athlete_id;
        this.coach_id = coach_id;
        this.rating = rating;
        this.review_txt = review_txt;
        this.date = date;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public int getProgram_id() {
        return program_id;
    }

    public void setProgram_id(int program_id) {
        this.program_id = program_id;
    }

    public int getAthlete_id() {
        return athlete_id;
    }

    public void setAthlete_id(int athlete_id) {
        this.athlete_id = athlete_id;
    }

    public int getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(int coach_id) {
        this.coach_id = coach_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview_txt() {
        return review_txt;
    }

    public void setReview_txt(String review_txt) {
        this.review_txt = review_txt;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reviews [review_id=" + review_id + ", program_id=" + program_id + ", athlete_id=" + athlete_id
                + ", coach_id=" + coach_id + ", rating=" + rating + ", review_txt=" + review_txt + ", date=" + date
                + "]";
    }

     

}