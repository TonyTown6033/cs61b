import java.lang.*;

public class Planet {
    private static final double G = 6.67e-11;
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP,double yP,double xV,double yV,double m,String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double dx = this.xxPos - p.xxPos;
        double dy = this.yyPos - p.yyPos;
        double distance = Math.pow(dx,2) + Math.pow(dy,2);
        distance = Math.pow(distance,0.5);
        return distance;
    }

    public double calcForceExertedBy(Planet p){
        double distance = this.calcDistance(p);
        double Force = G*this.mass*p.mass/Math.pow(distance,2);
        return Force;
    }

    public double calcForceExertedByX(Planet p){
        double x = p.xxPos - this.xxPos;
        double distance = this.calcDistance(p);
        double force = this.calcForceExertedBy(p);
        double forceX = x/distance*force;
        return forceX;
    }

    public double calcForceExertedByY(Planet p){
        double y = p.yyPos - this.yyPos;
        double distance = this.calcDistance(p);
        double force = this.calcForceExertedBy(p);
        double forceY = y/distance*force;
        return forceY;
    }

    public double calcNetForceExertedByX(Planet[] p){
        double netForceX = 0.0;
        for(Planet s:p){
            if(this.equals(s)){
                continue;
            }
            netForceX += this.calcForceExertedByX(s);
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(Planet[] p){
        double netForceY = 0.0;
        for(Planet s:p){
            if(this.equals(s)){
                continue;
            }
            netForceY += this.calcForceExertedByY(s);
        }
        return netForceY;
    }

    public void update(double dt, double fx, double fy){
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        this.xxVel = this.xxVel + ax*dt;
        this.yyVel = this.yyVel + ay*dt;
        this.xxPos = this.xxPos + this.xxVel * dt;
        this.yyPos = this.yyPos + this.yyVel * dt;

    }

    public void draw(){
        StdDraw.picture(this.xxPos,this.yyPos,"./images/"+this.imgFileName);
    }
}