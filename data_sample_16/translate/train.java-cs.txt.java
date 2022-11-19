public static DVConstraint createExplicitListConstraint(String[] explicitListValues) {return new DVConstraint(null, explicitListValues);}
public String toString(){StringBuilder buffer = new StringBuilder();buffer.append("[SCL]\n");buffer.append("    .numerator            = ").append("0x").append(HexDump.toHex(  getNumerator ())).append(" (").append( getNumerator() ).append(" )");buffer.append(System.getProperty("line.separator"));buffer.append("    .denominator          = ").append("0x").append(HexDump.toHex(  getDenominator ())).append(" (").append( getDenominator() ).append(" )");buffer.append(System.getProperty("line.separator"));buffer.append("[/SCL]\n");return buffer.toString();}
public UDFFinder getUDFFinder(){return _uBook.getUDFFinder();}
public void reset(int point) {this.point = point;ends.next = 0;starts.next = 0;}
public void write(String str, int offset, int count) {write(str.substring(offset, offset + count).toCharArray());}
public void addRecords(RecordStream rs) {while (true) {if (!readARecord(rs)) {break;}}}
public ListStackSetsResult listStackSets(ListStackSetsRequest request) {request = beforeClientExecution(request);return executeListStackSets(request);}
public void setCollector(Collector collector) {this.collector = collector;}
public String toString() {if (noBreak == null && postBreak == null && preBreak != null&& preBreak.equals("-")) {return "-";}StringBuilder res = new StringBuilder("{");res.append(preBreak);res.append("}{");res.append(postBreak);res.append("}{");res.append(noBreak);res.append('}');return res.toString();}
public DescribeRegionsResult describeRegions() {return describeRegions(new DescribeRegionsRequest());}
public VCenterRecord clone() {return copy();}
public AutomatonQuery(final Term term, Automaton automaton) {this(term, automaton, Operations.DEFAULT_MAX_DETERMINIZED_STATES);}
public String toString() {return getClass().getSimpleName() + "[" + getFile().getPath() + "]";}
public void fromRaw(int[] ints, int p) {w1 = ints[p];w2 = ints[p + 1];w3 = ints[p + 2];w4 = ints[p + 3];w5 = ints[p + 4];}
public void remove(int index) {checkIndex(index);_mergedRegions.remove(index);}
public int size() {return mSize;}
