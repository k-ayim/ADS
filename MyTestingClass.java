public class MyTestingClass {
    private String data;

    public MyTestingClass(String data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        for (int i = 0; i < data.length(); i++) {
            hash = 31 * hash + data.charAt(i);
        }
        return hash;
    }

    @Override
    public String toString() {
        return data;
    }
}
