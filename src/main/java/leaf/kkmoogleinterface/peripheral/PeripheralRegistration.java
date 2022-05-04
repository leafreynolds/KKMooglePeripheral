package leaf.kkmoogleinterface.peripheral;

import dan200.computercraft.api.ComputerCraftAPI;

public class PeripheralRegistration
{
	public static MooglePeripheralProvider integrationPeripheralProvider = new MooglePeripheralProvider();

	public static void register()
	{
		ComputerCraftAPI.registerPeripheralProvider(integrationPeripheralProvider);
	}
}
