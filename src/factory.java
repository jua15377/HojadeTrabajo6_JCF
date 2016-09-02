

public class factory{

    public Set<Developer> crearSet(String implemetacioSet) {

        if ("HS".equalsIgnoreCase(implemetacioSet)) {
            return new HashSet<Developer>();
        }
        else if ("TS".equalsIgnoreCase(implemetacioSet)) {
            return new TreeSet<Developer>();

        }

        else if ("LHS".equalsIgnoreCase(implemetacioSet)) {
            return new LinkedHashSet<Developer>();
        }
    }
}