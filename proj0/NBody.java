
public class NBody {
    public static double readRadius(String fileName){
        In in = new In(fileName);
        int num = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String fileName){
        In in = new In(fileName);
        int sumOfPlanet = in.readInt();
        double radius = in.readDouble();
        Planet[] planets = new Planet[sumOfPlanet];
        int i = 0;
        while (i<sumOfPlanet){
            planets[i] = new Planet(0.0,0.0,0.0,0.0,0.0,"SS");
            planets[i].xxPos = in.readDouble();
            planets[i].yyPos = in.readDouble();
            planets[i].xxVel = in.readDouble();
            planets[i].yyVel = in.readDouble();
            planets[i].mass = in.readDouble();
            planets[i].imgFileName = in.readString();
            i++;
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt =Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        StdDraw.setScale(-radius,radius);
        StdDraw.clear();
        String background = "./images/starfield.jpg";
        StdDraw.picture(0,0,background);
        for(Planet p : planets){
            p.draw();
        }
        StdDraw.show();
        StdDraw.pause(10);
        StdDraw.enableDoubleBuffering();
        double time = 0;
        double[] xForce = new double[planets.length];
        double[] yForce = new double[planets.length];
        int i = 0;
        int j = 0;
        while (time <= T){
            i = 0;
            for(Planet p:planets){
                xForce[i] = p.calcNetForceExertedByX(planets);
                yForce[i] = p.calcNetForceExertedByY(planets);
                i++;
            }
            StdDraw.clear();
            StdDraw.picture(0,0,background);
            j = 0;
            for(Planet p:planets){
                p.update(dt,xForce[j],yForce[j]);
                p.draw();
                j++;
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }
}