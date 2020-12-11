public class FileSystem {
    public static Globals global = new Globals();

    int FS_Boot()
    {
        if (global.fs_booted)
        {
            global.osErrMsg = "E_FILE_BOOT";
            return -1;
        }
        else if (!global.fs_is_available)
        {
            if (global.external_disk_exists)
            {
                global.fs_is_available = true;
                return 0;
            } else {
                global.external_disk_exists = true;
                //TODO: Copy external_disk into working_disk
                if(global.working_disk_exists)
                {
                    global.fs_is_available = true;
                    return 0;
                } else {
                    global.osErrMsg = "E_FILE_BOOT";
                    return -1;
                }
            }
        } else {
            return -1;
        }
    }


    int FS_Sync()
    {
        if (global.fs_is_available)
        {
            //TODO: Copy working_disk contents into external_disk
            return 0;
        } else {
            return -1;
        }
    }


    int FS_Reset() {
        global.fs_is_available = false;
        int result = FS_Sync();
        if (result == 0)
        {
            return 0;
        } else {
            global.osErrMsg = "E_FILE_RESET";
            return -1;
        }
    }



}
