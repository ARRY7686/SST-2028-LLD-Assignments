public class RulesFactory {
    public static Rules getRules(Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                return new Rules(new EasyRules());
            case ADVANCED:
                return new Rules(new AdvancedRules());
            default:
                return new Rules(new BasicRules());
        }
    }
}