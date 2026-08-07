public class Driver 
{

    public static void main(String[] args) 
    {

        String template =
                "Dear {name}, order {id} ships {date}.";

        String[] names = {
                "name",
                "id"
        };

        String[] values = {
                "Niyati",
                "ABC070"
        };

        System.out.println(
                TemplateFiller.fill(template, names, values));

    }

}