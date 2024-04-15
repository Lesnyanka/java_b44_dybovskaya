package ru.stqa.mantis.model;

public record UserData (String username, String realname, String email) {




    public UserData() {this("username", "realname", "user3@localhost");
    }

    public UserData withUsername(String username){
        return new UserData(username, this.realname, this.email);
    }

    public UserData withRealname(String realname){
        return new UserData(this.username, realname, this.email);
    }
    public UserData withEmail(String email){
    return new UserData(this.username, this.realname, email);
}


}

