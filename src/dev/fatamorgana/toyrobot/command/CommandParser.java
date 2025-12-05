package dev.fatamorgana.toyrobot.command;

public interface CommandParser {
	InitializeCommand parseInitCommand(String input);
	GenericCommand parseGenericCommand(String input);
}
