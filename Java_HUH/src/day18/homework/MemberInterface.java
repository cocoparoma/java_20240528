package day18.homework;

public interface MemberInterface {
    abstract void init();
    abstract void insertMember();
    abstract void updateMember();
    abstract void deleteMember();
    abstract void showAll();
    abstract Member findById(String id);
    abstract void save(String file);
    abstract void load(String file);
}
