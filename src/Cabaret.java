import java.util.ArrayList;
public class Cabaret {
    private String name;
    private ArrayList<Performer> performers;

    public Cabaret(String name)
    {
        this.name = name;
        performers = new ArrayList<Performer>();

    }

    public String getName() {
        return name;
    }

    public ArrayList<Performer> getPerformers() {
        return performers;
    }

    public boolean addPerformer(Performer p)
    {

        if(performers.indexOf(p) == -1)
        {
            performers.add(p);
            return true;
        }
        return false;
    }

    public boolean removePerformer(Performer p)
    {
        int index = performers.indexOf(p);
        if(index != -1)
        {
            performers.remove(index);
            return true;
        }
        return false;
    }

    public double averagePerformerAge()
    {
        int ageSum = 0;
        for(Performer p : performers)
        {
            ageSum += p.getAge();
        }
        double average = ageSum / (double) performers.size();
        return average;
    }

    public ArrayList<Performer> performersOverAge(int age)
    {
        ArrayList<Performer> list = new ArrayList<Performer>();
        for(Performer p : performers)
        {
            if(p.getAge() >= age)
            {
                list.add(p);
            }
        }
        return list;
    }

    public void groupRehearsal()
    {
        for(Performer p : performers)
        {
            System.out.println("REHEARSAL CALL! " + p.getName());

            if(p instanceof Comedian)
            {
                Comedian c = (Comedian) p;
                c.rehearse(false);
            }
            else
            {
                p.rehearse();
            }
        }
    }

    public void CabaretShow()
    {
        for(Performer p : performers)
        {
            System.out.println("Welcome to the cabaret! Next act up... " + p.getName());

            if(p instanceof Dancer)
            {
                Dancer d = (Dancer) p;
                d.pirouette(2);
            }
            p.perform();
        }
    }

}
