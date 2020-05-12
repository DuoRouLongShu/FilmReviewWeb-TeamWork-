package com.FilmReviewWeb.Model;

/**用户反馈
 * @author HTwo2O
 * @date 2020/5/12 20:58
 */
public class Feedback {
    private int feedbackId;
    private int userId;
    private String userName;
    private String creatTime;
    private String text;

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId=" + feedbackId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", creatTime='" + creatTime + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
