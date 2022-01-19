public final FileDescriptor getFD() throws IOException {return fd;}
public MoreLikeThisQuery(String likeText, String[] moreLikeFields, Analyzer analyzer, String fieldName) {this.likeText = Objects.requireNonNull(likeText);this.moreLikeFields = Objects.requireNonNull(moreLikeFields);this.analyzer = Objects.requireNonNull(analyzer);this.fieldName = Objects.requireNonNull(fieldName);}
public DocValuesOrdinalsReader(String field) {this.field = field;}
public FormatTrackingHSSFListener(HSSFListener childListener) {this(childListener, LocaleUtil.getUserLocale());}
public DescribeScalingParametersResult describeScalingParameters(DescribeScalingParametersRequest request) {request = beforeClientExecution(request);return executeDescribeScalingParameters(request);}
public DescribeFileSystemsResult describeFileSystems(DescribeFileSystemsRequest request) {request = beforeClientExecution(request);return executeDescribeFileSystems(request);}
public void enterRecursionRule(ParserRuleContext localctx, int state, int ruleIndex, int precedence) {Pair<ParserRuleContext, Integer> pair = new Pair<ParserRuleContext, Integer>(_ctx, localctx.invokingState);_parentContextStack.push(pair);super.enterRecursionRule(localctx, state, ruleIndex, precedence);}
public OldFormulaRecord(RecordInputStream ris) {super(ris, ris.getSid() == biff2_sid);if (isBiff2()) {field_4_value = ris.readDouble();} else {long valueLongBits  = ris.readLong();specialCachedValue = FormulaSpecialCachedValue.create(valueLongBits);if (specialCachedValue == null) {field_4_value = Double.longBitsToDouble(valueLongBits);}}if (isBiff2()) {field_5_options = (short)ris.readUByte();} else {field_5_options = ris.readShort();}int expression_len = ris.readShort();int nBytesAvailable = ris.available();field_6_parsed_expr = Formula.read(expression_len, ris, nBytesAvailable);}