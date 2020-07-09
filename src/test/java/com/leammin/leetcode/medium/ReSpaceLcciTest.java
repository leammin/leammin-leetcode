package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.ReSpaceLcci;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-07-09
 */
class ReSpaceLcciTest extends AbstractTest<ReSpaceLcci> {
    @Override
    protected Testsuite<ReSpaceLcci> testsuite() {
        return Testsuite.<ReSpaceLcci>builder()
                .add(ExpectedTestcase.of(t -> t.respace(new String[]{"looked", "just", "like", "her", "brother"},
                        "jesslookedjustliketimherbrother"), 7))
                .add(ExpectedTestcase.of(t -> t.respace(new String[]{"axxpxakkxktpa", "aappk", "kddxxp", "p", "atxtdtpkt",
                        "ptxkatdakp", "padpatxaptpaatkadaxka", "xd", "xa", "kptkaxxpptpkxaxtx", "t",
                        "atdxkttpppakkxkxpxdxxapakaadaxkakapxptdpkxkaadtx", "kp", "xa", "pkkataxkakkxxktxxdptatkkxta",
                        "dxttapxpxkxttkktpkx", "tat", "txpdakdxpaa", "axxkaxkxkkkdpkpttxdkpaaakkakdkkdxatd", "paxaa"},
                        "ppkaxpxddkpaatttxtpdtaxtadxaxatxtdtpktdxpppkaxpxddkpaatttxtpdtaxtadx"), 28))
                .build();
    }
}


