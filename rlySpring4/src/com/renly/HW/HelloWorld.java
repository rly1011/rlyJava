package com.renly.HW;

public class HelloWorld {
	private  String user;

    public void setUser(String user) {
        this.user = user;
    }

    public HelloWorld() {
    }

    public HelloWorld(String user) {
        this.user = user;
    }

    public void  helloWorld(){
        System.out.println("Hello:"+user);
    }

    
    @Override
	public String toString() {
		return "HelloWorld [user=" + user + "]";
	}
}
