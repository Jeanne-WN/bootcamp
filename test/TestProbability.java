import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

//Ensures Probability represents the value of the expectation that an event will occur in mathematical way
public class TestProbability {

    public final int totalProbability = 1;
    public final Double chanceOfGettingSomeNumberInADie = 0.167;

    @Test
    public void verifyEqualityOfChanceOfDice3AndDice6() {
        Probability chanceOf3 = new Probability(chanceOfGettingSomeNumberInADie);
        Probability chanceOf6 = new Probability(chanceOfGettingSomeNumberInADie);

        assertThat(chanceOf3, equalTo(chanceOf6));
    }

    @Test
    public void verifyIfTwoObjectsAreDifferent() throws Exception {
        Probability obj1 = new Probability(0.2);
        Probability obj2 = new Probability(0.25);

        assertThat(false, equalTo(obj1.equals(obj2)));
    }

    @Test
    public void chancesOfGettingNotRollingThree() throws Exception {
        Probability probabilityOfRollingThree = new Probability(chanceOfGettingSomeNumberInADie);

        assertThat(probabilityOfRollingThree.not(), equalTo(new Probability(totalProbability - chanceOfGettingSomeNumberInADie)));
    }

    @Test
    public void chancesOfGettingOneAndSixOnTwoDifferentDies() throws Exception {
        Probability probability = new Probability(chanceOfGettingSomeNumberInADie);
        Probability probabilityOfSix = new Probability(chanceOfGettingSomeNumberInADie);
        Probability probabilityOfBothOneAndSix = new Probability(chanceOfGettingSomeNumberInADie * chanceOfGettingSomeNumberInADie);

        assertThat(probabilityOfBothOneAndSix.equals(probability.and(probabilityOfSix)), is(true));
    }

    @Test
    public void chanceOfGettingOneOrSix() throws Exception {
        Probability probabilityOfGettingOne = new Probability(chanceOfGettingSomeNumberInADie);
        Probability probabilityOfGettingSix = new Probability(chanceOfGettingSomeNumberInADie);
        Probability probabilityOfGettingOneOrSix = probabilityOfGettingOne.not().and(probabilityOfGettingSix.not()).not();

        assertThat(probabilityOfGettingOneOrSix.equals(probabilityOfGettingOne.or(probabilityOfGettingSix)), is(true));
    }
}
