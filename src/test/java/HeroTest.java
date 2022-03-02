import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void NewHeroObjectGetsCorrectlyCreated_true() throws Exception {
        Hero hero = new Hero("Superman", 30,  "Strength", "Love");
        assertTrue(hero instanceof Hero);
    }
    @Test
    public void AllHeroesContainsAllHeroes_true() {
        Hero hero = new Hero("Superman", 30,  "Strength", "Love");
        Hero hero1 = new Hero("Superman1", 30,  "Strength", "Love");
        assertTrue(Hero.getAll().contains(hero));
        assertTrue(Hero.getAll().contains(hero1));
    }
    @Test
    public void getId_heroesInstantiateWithAnID_1() throws Exception{
        Hero.clear();
        Hero hero = new Hero("Superman", 30,  "Strength", "Love");
        assertEquals(1,hero.getId());
    }
    @Test
    public void findReturnsCorrectHero() throws Exception {
        Hero.clear();
        Hero hero = new Hero("Superman", 30,  "Strength", "Love");
        assertEquals(1,hero.findHero(hero.getId()).getId());
    }
}