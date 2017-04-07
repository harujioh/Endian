package jp.harujioh.endian.little;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import jp.harujioh.endian.LittleEndianUtil;

/**
 * リトルエンディアンutilクラスのlong値テスト
 * 
 * @author rhirata
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LittleEndianLongTest {

	/**
	 * 8byteからlong値を生成
	 * 
	 * @param b1
	 * @param b2
	 * @param b3
	 * @param b4
	 * @param b5
	 * @param b6
	 * @param b7
	 * @param b8
	 * @return
	 */
	public static long get(int b1, int b2, int b3, int b4, int b5, int b6, int b7, int b8) {
		return ((long) b1 << 56) | ((long) b2 << 48) | ((long) b3 << 40) | ((long) b4 << 32) | ((long) b5 << 24)
				| (b6 << 16) | (b7 << 8) | b8;
	}

	/**
	 * 配列長とバイト長が同じバッファから取得するテスト
	 */
	@Test
	public void getTest() {
		assertThat( //
				LittleEndianUtil.getLong(new int[] { 0x01, 0x23, 0x45, 0x67, 0x89, 0xab, 0xcd, 0xef }), //
				is(get(0xef, 0xcd, 0xab, 0x89, 0x67, 0x45, 0x23, 0x01)));
	}

	/**
	 * 配列長がバイト長より小さいバッファから取得するテスト
	 */
	@Test
	public void getNotEnoughTest() {
		assertThat( //
				LittleEndianUtil.getLong(new int[] { 0x01, 0x23 }), //
				is(get(0x23, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00)));
	}

	/**
	 * 配列長がバイト長より大きいバッファから取得するテスト
	 */
	@Test
	public void getEnoughTest() {
		assertThat( //
				LittleEndianUtil.getLong(new int[] { 0x01, 0x23, 0x45, 0x67, 0x89, 0xab, 0xcd, 0xef, 0x11 }), //
				is(get(0xef, 0xcd, 0xab, 0x89, 0x67, 0x45, 0x23, 0x01)));
	}

	/**
	 * バッファからoffsetを指定して取得するテスト
	 */
	@Test
	public void getOffsetTest() {
		assertThat( //
				LittleEndianUtil.getLong(
						new int[] { 0x01, 0x23, 0x45, 0x67, 0x89, 0xab, 0xcd, 0xef, 0x11, 0x22, 0x33, 0x44 }, 2), //
				is(get(0x22, 0x11, 0xef, 0xcd, 0xab, 0x89, 0x67, 0x45)));
	}

	/**
	 * バッファからoffsetを指定するが、それ以降の配列長がバイト長より小さいバッファから取得するテスト
	 */
	@Test
	public void getOffsetNotEnoughLengthTest() {
		assertThat( //
				LittleEndianUtil.getLong(new int[] { 0x01, 0x23, 0x45, 0x67, 0x89, 0xab, 0xcd, 0xef }, 6), //
				is(get(0xef, 0xcd, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00)));
	}

	/**
	 * バッファからoffsetとlengthを指定して取得するテスト
	 */
	@Test
	public void getOffsetLengthTest() {
		assertThat( //
				LittleEndianUtil.getLong(
						new int[] { 0x01, 0x23, 0x45, 0x67, 0x89, 0xab, 0xcd, 0xef, 0x11, 0x22, 0x33, 0x44 }, 3, 3), //
				is(get(0xab, 0x89, 0x67, 0x00, 0x00, 0x00, 0x00, 0x00)));
	}

	/**
	 * バッファからoffsetとlengthを指定するが、それ以降の配列長がバイト長より小さいバッファから取得するテスト
	 */
	@Test
	public void getOffsetLengthNotEnoughLengthTest() {
		assertThat( //
				LittleEndianUtil.getLong(new int[] { 0x01, 0x23, 0x45, 0x67, 0x89, 0xab, 0xcd, 0xef }, 3, 3), //
				is(get(0xab, 0x89, 0x67, 0x00, 0x00, 0x00, 0x00, 0x00)));
	}
}
