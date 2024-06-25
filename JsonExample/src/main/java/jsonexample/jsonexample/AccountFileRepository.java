package jsonexample.jsonexample;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class AccountFileRepository implements AccountRepository {
    private static final String fileName = "data.txt";

    @Override
    public void loadJson(List<Account> accountList) throws Exception {
        File file = new File(fileName);
        if (!file.exists()) {
            return; // 파일이 없을때 실행하면 예외 없도록 처리함
        }
        BufferedReader inFile = new BufferedReader(new FileReader(file));
        String sLine = null;
        accountList.clear();
        while ((sLine = inFile.readLine()) != null) {
            Account account = new Account();
            String[] items = sLine.split(",");
            account.setName(items[0]);
            account.setBankNumber(items[1]);
            account.setCurrent(Integer.parseInt(items[2]));
            accountList.add(account);
        }
    }

    @Override
    public void saveJson(List<Account> accountList) throws Exception {
        FileOutputStream fileOut = new FileOutputStream(fileName);
        OutputStreamWriter writer = new OutputStreamWriter(fileOut, StandardCharsets.UTF_8);

        for (Account account : accountList) {
            String str = String.format("%s,%s,%d,\n"
                    , account.getName(), account.getBankNumber(), account.getCurrent());
            writer.write(str);
        }
        writer.close();
    }
}