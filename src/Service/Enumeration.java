package Service;

public class Enumeration {
    public enum AirplaneNames {
        F16("Jumbo"),
        F17;

        String type;
        AirplaneNames(){}
        AirplaneNames(String type)
        {
            this.type = type;
        }

    }
}
