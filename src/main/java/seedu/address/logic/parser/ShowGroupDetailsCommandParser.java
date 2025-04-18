package seedu.address.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.ShowGroupDetailsCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new {@code ShowGroupDetailsCommand} object
 */
public class ShowGroupDetailsCommandParser implements Parser<ShowGroupDetailsCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the {@code ShowGroupDetailsCommand}
     * and returns an {@code ShowGroupDetailsCommand} object for execution.
     *
     * @param args The user input arguments as a {@code String}.
     * @return An {@code ShowGroupDetailsCommand} object containing the parsed index.
     * @throws ParseException If the user input does not conform to the expected format.
     */
    @Override
    public ShowGroupDetailsCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new ShowGroupDetailsCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    pe.getMessage() + "\n" + ShowGroupDetailsCommand.MESSAGE_USAGE, pe);
        }
    }
}
