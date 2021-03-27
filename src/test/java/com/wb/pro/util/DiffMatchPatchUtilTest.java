package com.wb.pro.util;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author wangbin
 * @date 2021/3/25 15:42
 */
public class DiffMatchPatchUtilTest {
    @Test
    public void diffTest() {
        getDiffStr("你好啊","你好");
        getDiffStr("你好啊","你好坏");
        getDiffStr("你好啊","你好坏啊");
        getDiffStr("","你好坏啊");
        getDiffStr("啊坏","你好坏啊");
    }

    private void getDiffStr(String oldStr,String newStr){
        DiffMatchPatchUtil dmp = new DiffMatchPatchUtil();
        LinkedList<DiffMatchPatchUtil.Diff> diffFile = dmp.diffMain(oldStr,newStr);
        dmp.diffCleanupSemantic(diffFile);
        LogPrintUtil.systemOutPrintln(DiffMatchPatchUtil.linkedListDiff2HtmlString(diffFile));
    }

}
