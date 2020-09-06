package JavaCore.Base.Lesson5;

public class Lesson5 {
    public static void main(String[] args) {
        Employer[] persArray = new Employer[5]; // Вначале объявляем массив объектов
        persArray[0] = new Employer("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
        persArray[1] = new Employer("Petrov Petr", "Manager", "petpetr@mailbox.com", "892343663", 60000, 35);
        persArray[2] = new Employer("Kurochkina Anna", "Manager", "kuranna@mailbox.com", "892236663", 30000, 27);
        persArray[3] = new Employer("Evdokimov Alex", "Guardian", "evdalex@mailbox.com", "892636933", 20000, 45);
        persArray[4] = new Employer("Kopytkina Elena", "Cleaner", "popytelena@mailbox.com", "891642342", 15000, 60);

        for (Employer person : persArray)
        {
            if (person.getAge() > 40) {
                person.info();
            }
        }
    }
}
