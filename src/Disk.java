import java.util.ArrayList;


public class Disk extends Directory {
    public Boolean disk_is_called = false;
    public ArrayList<FileSystem> file_table = new ArrayList<>();

    static Globals global;
    Sector[] sector;

    public Disk()
    {
        sector = new Sector[global.NUM_SECTORS];
    }


    int Disk_Init()
    {
        if (!disk_is_called && !global.fs_booted)
        {
            for (int row = 0; row < sector.length; row++)
            {
                //Todo: Reset all data in sector array to null
            }
            disk_is_called = true;
            return 0;
        } else {
            return -1;
        }
    }

    int Disk_Load()
    {
        if (!global.fs_booted) {
            for (int i = 0; i < global.external_disk.file_table.size() && global.external_disk.file_table.size() > 0; i++) {
                global.working_disk.file_table.add(i, global.external_disk.file_table.get(i));
            }
            return 0;
        } else {
            return -1;
        }
    }

    int Disk_Save()
    {
        for (int i = 0; i < global.working_disk.file_table.size() && global.working_disk.file_table.size() > 0; i++)
        {
            global.external_disk.file_table.add(i, global.working_disk.file_table.get(i));
        }
        return 0;
    }

    int Disk_Write(int sectorIndex, String buffer)
    {
        if (sectorIndex < 0 || sectorIndex >= global.NUM_SECTORS || buffer == null)
        {
            global.diskErrMsg = "E_WRITE_INVALID_PARAM";
            return -1;
        } else {
            sector[sectorIndex].data = buffer;
            return 0;
        }
    }

    int Disk_Read(int sectorIndex, String buffer)
    {
        if (sectorIndex < 0 || sectorIndex >= global.NUM_SECTORS || buffer == null)
        {
            global.diskErrMsg = "E_READ_INVALID_PARAM";
            return -1;
        } else {
            buffer = sector[sectorIndex].data;
            global.tempBuffer = buffer;
            return 0;
        }
    }





}

class Sector {
    Globals global;
    int size = global.SECTOR_SIZE;
    String data;

}
