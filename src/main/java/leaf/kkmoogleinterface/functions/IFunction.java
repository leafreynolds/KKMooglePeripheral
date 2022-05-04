package leaf.kkmoogleinterface.functions;

import dan200.computercraft.api.lua.IArguments;
import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.lua.MethodResult;

/** Template for Handles Mod Methods*/
public interface IFunction {
	/** Defines the method name and registry id. E.g. setDestination*/
    public String getName();
    /** The logic to run when this function is executed. If we don't want to return anything, return an empty {@linkplain MethodResult} to prevent NPE*/
    public MethodResult run(IArguments args) throws LuaException;
}
