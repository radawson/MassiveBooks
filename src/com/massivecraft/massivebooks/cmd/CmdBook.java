package com.massivecraft.massivebooks.cmd;

import com.massivecraft.massivebooks.ConfServer;
import com.massivecraft.massivebooks.Perm;
import com.massivecraft.mcore.cmd.HelpCommand;
import com.massivecraft.mcore.cmd.req.ReqHasPerm;

public class CmdBook extends MassiveBooksCommand
{
	// SubCommands
	public CmdBookUnsign cmdBookUnsign = new CmdBookUnsign();
	// TODO
	
	public CmdBook()
	{
		super();
		
		// Aliases
		this.setAliases(ConfServer.aliasesBook);
		
		// Help SubCommand 
		this.addSubCommand(HelpCommand.get());
		
		// Add SubCommands
		this.addSubCommand(this.cmdBookUnsign);
		// TODO
		
		// Requirements
		this.addRequirements(ReqHasPerm.get(Perm.BOOK.node));
	}
	
	@Override
	public void perform()
	{
		this.getCommandChain().add(this);
		HelpCommand.getInstance().execute(this.sender, this.args, this.commandChain);
	}
}