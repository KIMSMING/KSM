package teachertest0628.teachertest0628;

import com.softagape.sbtest0628.EPhoneGroup;
import com.softagape.sbtest0628.IPhoneBook;
import com.softagape.sbtest0628.IPhoneBookRepository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class PhoneBookTextRepository implements IPhoneBookRepository<IPhoneBook> {
    private String fileName;

    public PhoneBookTextRepository(String fileName) {
        this.fileName = fileName;
    }

    public IPhoneBook getObjectFromText(String str) throws Exception {
        if (str == null) {
            throw new Exception("Error : Input str is null");
        }
        IPhoneBook object = new PhoneBook();
        String[] items = str.split(",");
        object.setId(Long.parseLong(items[0]));
        object.setName(items[1]);
        object.setGroup(EPhoneGroup.valueOf(items[2]));
        object.setPhoneNumber(items[3]);
        object.setEmail(items[4]);
        return object;
    }

    public String getTextFromObject(IPhoneBook object) throws Exception {
        if (object == null) {
            throw new Exception("Error : Input object is null");
        }
        String str = String.format("%d,%s,%s,%s,%s\n"
                , object.getId(), object.getName(), object.getGroup()
                , object.getPhoneNumber(), object.getEmail());
        return str;
    }

    @Override
    public boolean saveData(List<IPhoneBook> listData) throws Exception {
        if (listData == null || listData.size() <= 0) {
            return false;
        }
        if (fileName == null || fileName.isEmpty()) {
            return false;
        }
        FileOutputStream fileOut = new FileOutputStream(fileName);
        OutputStreamWriter writer = new OutputStreamWriter(fileOut, StandardCharsets.UTF_8);

        for (IPhoneBook object : listData) {
            String str = getTextFromObject(object);
            writer.write(str);
        }
        writer.close();
        return true;
    }

    @Override
    public boolean loadData(List<IPhoneBook> listData) throws Exception {
        if (listData == null) {
            return false;
        }
        File file = new File(fileName);
        if (!file.exists()) {
            return true; // 파일이 없을때 실행하면 예외 없도록 처리함
        }
        BufferedReader inFile = new BufferedReader(new FileReader(file));
        String sLine = null;
        listData.clear();
        while ((sLine = inFile.readLine()) != null) {
            IPhoneBook object = this.getObjectFromText(sLine);
            listData.add(object);
        }
        return true;
    }
}
