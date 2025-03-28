interface HouseRequirements {
    boolean hasDiningRoom(); 
    int nResidents(); 
    void moveIn(Student s);
    Student moveOut(Student s); 
    boolean isResident(Student s); 
}
