import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquadTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void NewSquadObjectGetsCorrectlyCreated_true() throws Exception {
        Squad squad = new Squad("Titans", "Revenging the titans");
        assertTrue(squad instanceof Squad);
    }
    @Test
    public void AllSquadsContainsAllSquads_true() {
        Squad squad = new Squad("Titans", "Revenging the titans");
        Squad squad1 = new Squad("Titans", "Revenging the titans");
        assertTrue(Squad.getAll().contains(squad));
        assertTrue(Squad.getAll().contains(squad1));
    }
    @Test
    public void getId_squadsInstantiateWithAnID_1() throws Exception{
        Squad.clear();
        Squad squad = new Squad("Titans", "Revenging the titans");
        assertEquals(1,squad.getId());
    }
    @Test
    public void findReturnsCorrectSquad() throws Exception {
        Squad.clear();
        Squad squad = new Squad("Titans", "Revenging the titans");
        assertEquals(1,squad.findSquad(squad.getId()).getId());
    }
}