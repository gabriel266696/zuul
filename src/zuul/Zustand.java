package zuul;

public interface Zustand {
	Zustand heilen();
	Zustand leichtVerletzen();
	Zustand starkVerletzen();
	Zustand toetlichVerletzen();
}