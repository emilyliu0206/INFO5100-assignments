package Assignment4;

//Q2. ​For this problem you will write a Java program that uses polymorphism
//    and abstract classes and methods. The program should implement the design indicated
//    in this UML diagram

abstract class MoodyObject{
    protected String mood;
    //returns the mood: sad or happy - depending on which object sends the message
    protected abstract String getMood();

    //each object expresses a different emotion
    protected abstract void expressFeelings();

    //an object responds according to how it feels, print "I feel happy(or sad) today!"
    public void queryMood() {
        System.out.println("I feel " + getMood() +" today!" );
    }
}

class SadObject extends MoodyObject{
    SadObject(){
        this.mood = "sad";
    }
    //returns a string indicating sad
    protected String getMood(){
        return mood;
    };

    //print crying string: " 'wah' 'boo hoo' 'weep' 'sob' 'weep' "
    public void expressFeelings(){
        System.out.println(" 'wah' 'boo hoo' 'weep' 'sob' 'weep' ");
    };

    //returns message about self: "Subject cries a lot";
    public String toString(){
        return "Subject cries a lot";
    };
}

class HappyObject extends MoodyObject{
    HappyObject(){
        this.mood = "happy";
    }
    //returns a string indicating happy
    protected String getMood(){
        return mood;
    };

    //print laughter string: "hehehe...hahahah...HAHAHAHAHA!!!"
    public void expressFeelings(){
        System.out.println("hehehe...hahahah...HAHAHAHAHA!!!");
    };

    //returns message about self: "Subject laughs a lot"
    public String toString(){
        return "Subject laughs a lot";
    };
}

class PsychiatristObject​{
    //asks a moody object about its mood
    public void examine(MoodyObject moodyObject){
        System.out.println("How are you feeling today?");
    };

    //a moodyObject is observed to either laugh or cry
    public void observe(MoodyObject moodyObject){
        System.out.println("Observation: " + moodyObject.toString());
    };
}

