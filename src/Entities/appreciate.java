package Entities;

public class appreciate {
    private  int  Id_user ;
    private  int Id_article  ;
    private boolean like;
    public void appreciate( int user, int article,boolean like)
        {
            this.Id_article=article;
            this.Id_user=user;
            this.like=like;
        }
    public int getId_article() {
        return Id_article;
    }
    public int getId_User(){
        return this.Id_user;
    }
}
