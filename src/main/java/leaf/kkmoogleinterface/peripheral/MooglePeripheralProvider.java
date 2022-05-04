package leaf.kkmoogleinterface.peripheral;

import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import online.kingdomkeys.kingdomkeys.block.MoogleProjectorBlock;

import javax.annotation.Nonnull;

public class MooglePeripheralProvider implements IPeripheralProvider
{
	@Nonnull
	@Override
	public LazyOptional<IPeripheral> getPeripheral(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull Direction side)
	{
		if (world.getBlockState(pos).getBlock() instanceof MoogleProjectorBlock)
		{
			return LazyOptional.of(MooglePeripheral::new);
		}
		return LazyOptional.empty();
	}
}
