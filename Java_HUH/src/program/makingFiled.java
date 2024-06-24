package program;

public interface makingFiled {

	abstract void init();

	abstract void insert();

	abstract void update();

	abstract void delete();

	abstract String finById(String id);

	abstract void showAll();

	abstract void save(String file);

	abstract void load(String file);
}
