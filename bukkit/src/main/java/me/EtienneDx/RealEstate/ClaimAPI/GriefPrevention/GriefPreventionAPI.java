package me.EtienneDx.RealEstate.ClaimAPI.GriefPrevention;

import java.util.UUID;

import org.bukkit.Location;

import me.EtienneDx.RealEstate.ClaimAPI.IClaim;
import me.EtienneDx.RealEstate.ClaimAPI.IClaimAPI;
import me.EtienneDx.RealEstate.ClaimAPI.IPlayerData;
import me.EtienneDx.RealEstate.Transactions.Transaction;
import me.ryanhamshire.GriefPrevention.GriefPrevention;

public class GriefPreventionAPI implements IClaimAPI
{

    @Override
    public IClaim getClaimAt(Location location) {
        return new GPClaim(GriefPrevention.instance.dataStore.getClaimAt(location, false, null));
    }

    @Override
    public void saveClaim(IClaim claim) {
        if(claim instanceof GPClaim)
            GriefPrevention.instance.dataStore.saveClaim(((GPClaim) claim).getClaim());
    }

    @Override
    public IPlayerData getPlayerData(UUID player) {
        return new GPPlayerData(GriefPrevention.instance.dataStore.getPlayerData(player));
    }

    @Override
    public void changeClaimOwner(IClaim claim, UUID newOwner) {
        if(claim instanceof GPClaim)
            GriefPrevention.instance.dataStore.changeClaimOwner(((GPClaim) claim).getClaim(), newOwner);
    }

    @Override
    public void registerEvents() {
        new ClaimPermissionListener().registerEvents();
    }

    public Integer getBuyerLeaseLimit(UUID player) {
        return null;
    }

    public Integer getBuyerPurchaseLimit(UUID player) {
        return null;
    }

    public Integer getBuyerRentalLimit(UUID player) {
        return null;
    }

    public Integer getOwnerLeaseLimit(UUID player) {
        return null;
    }

    public Integer getOwnerRentLimit(UUID player) {
        return null;
    }

    public Integer getOwnerSellLimit(UUID player) {
        return null;
    }

    public Transaction getTransaction(UUID uuid) {
        return null;
    }
}
